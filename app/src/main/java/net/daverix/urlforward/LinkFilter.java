/*
    UrlForwarder makes it possible to use bookmarklets on Android
    Copyright (C) 2016 David Laurell

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.daverix.urlforward;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

public class LinkFilter extends BaseObservable implements Parcelable {
    private long id;
    private String title;
    private String filterUrl;
    private String replaceText;
    private String replaceSubject;
    private long created;
    private long updated;
    private boolean encoded;

    public LinkFilter(Parcel in) {
        id = in.readLong();
        title = in.readString();
        filterUrl = in.readString();
        replaceText = in.readString();
        created = in.readLong();
        updated = in.readLong();
        encoded = in.readByte() == 1;
        replaceSubject = in.readString();
    }

    public LinkFilter() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(filterUrl);
        dest.writeString(replaceText);
        dest.writeLong(created);
        dest.writeLong(updated);
        dest.writeByte((byte) (encoded ? 1 : 0));
        dest.writeString(replaceSubject);
    }

    public static final Creator<LinkFilter> CREATOR = new Creator<LinkFilter>() {
        @Override
        public LinkFilter createFromParcel(Parcel source) {
            return new LinkFilter(source);
        }

        @Override
        public LinkFilter[] newArray(int size) {
            return new LinkFilter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getFilterUrl() {
        return filterUrl;
    }

    @Bindable
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return title;
    }

    @Bindable
    public String getReplaceText() {
        return replaceText;
    }

    @Bindable
    public long getCreated() {
        return created;
    }

    @Bindable
    public long getUpdated() {
        return updated;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setFilterUrl(String filterUrl) {
        this.filterUrl = filterUrl;
        notifyPropertyChanged(BR.filterUrl);
    }

    public void setReplaceText(String replaceText) {
        this.replaceText = replaceText;
        notifyPropertyChanged(BR.replaceText);
    }

    public void setCreated(long created) {
        this.created = created;
        notifyPropertyChanged(BR.created);
    }

    public void setUpdated(long updated) {
        this.updated = updated;
        notifyPropertyChanged(BR.updated);
    }

    @Bindable
    public boolean isEncoded() {
        return encoded;
    }

    public void setEncoded(boolean encoded) {
        this.encoded = encoded;
        notifyPropertyChanged(BR.encoded);
    }

    @Bindable
    public String getReplaceSubject() {
        return replaceSubject;
    }

    public void setReplaceSubject(String replaceSubject) {
        this.replaceSubject = replaceSubject;
        notifyPropertyChanged(BR.replaceSubject);
    }

    public void update(LinkFilter item) {
        setCreated(item.getCreated());
        setUpdated(item.getUpdated());
        setEncoded(item.isEncoded());
        setFilterUrl(item.getFilterUrl());
        setReplaceSubject(item.getReplaceSubject());
        setReplaceText(item.getReplaceText());
        setTitle(item.getTitle());
    }
}

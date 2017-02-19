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
package net.daverix.urlforward.filter;

import android.net.Uri;

import net.daverix.urlforward.LinkFilter;
import net.daverix.urlforward.UriCombinerException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;

public class UriFilterCombinerImpl implements UriFilterCombiner {
    @Inject
    public UriFilterCombinerImpl() {
    }

    @Override
    public Uri create(LinkFilter linkFilter, String url, String subject) throws UriCombinerException {
        if(linkFilter == null) throw new IllegalArgumentException("linkFilter is null");
        if(url == null) throw new IllegalArgumentException("url is null");

        try {
            String filterUrl = linkFilter.getFilterUrl();

            String replacement = linkFilter.isEncoded() ? URLEncoder.encode(url, "UTF-8") : url;
            String filteredUrl = filterUrl.replace(linkFilter.getReplaceText(), replacement);

            filteredUrl = filteredUrl.replace(linkFilter.getReplaceSubject(), subject);

            return Uri.parse(filteredUrl);
        } catch (UnsupportedEncodingException e) {
            throw new UriCombinerException(e);
        }
    }
}

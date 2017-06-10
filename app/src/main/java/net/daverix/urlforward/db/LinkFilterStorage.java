/*
    UrlForwarder makes it possible to use bookmarklets on Android
    Copyright (C) 2017 David Laurell

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
package net.daverix.urlforward.db;


import net.daverix.urlforward.LinkFilter;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface LinkFilterStorage {
    Completable insert(LinkFilter linkFilter);

    Completable update(LinkFilter linkFilter);

    Completable delete(long id);

    Single<LinkFilter> getFilter(long id);

    Observable<LinkFilter> queryAll();
}
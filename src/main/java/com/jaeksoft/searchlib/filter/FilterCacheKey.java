/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2008-2013 Emmanuel Keller / Jaeksoft
 * 
 * http://www.open-search-server.com
 * 
 * This file is part of OpenSearchServer.
 *
 * OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 * OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with OpenSearchServer. 
 *  If not, see <http://www.gnu.org/licenses/>.
 **/

package com.jaeksoft.searchlib.filter;

import java.io.IOException;

import com.jaeksoft.searchlib.SearchLibException;
import com.jaeksoft.searchlib.analysis.PerFieldAnalyzer;
import com.jaeksoft.searchlib.function.expression.SyntaxError;
import com.jaeksoft.searchlib.query.ParseException;
import com.jaeksoft.searchlib.request.AbstractSearchRequest;
import com.jaeksoft.searchlib.schema.SchemaField;

public class FilterCacheKey implements Comparable<FilterCacheKey> {

	private final String key;

	private final boolean isNegative;

	public FilterCacheKey(FilterAbstract<?> filter, SchemaField defaultField,
			PerFieldAnalyzer analyzer, AbstractSearchRequest request)
			throws ParseException, SyntaxError, SearchLibException, IOException {
		key = filter.getCacheKey(defaultField, analyzer, request);
		isNegative = filter.isNegative();
	}

	@Override
	public int compareTo(FilterCacheKey o) {
		if (isNegative != o.isNegative)
			return isNegative ? -1 : 1;
		return key.compareTo(o.key);
	}

	@Override
	public String toString() {
		return hashCode() + ' ' + key;
	}
}

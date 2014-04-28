/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2013-2014 Emmanuel Keller / Jaeksoft
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

package com.jaeksoft.searchlib.webservice.synonyms;

import javax.ws.rs.core.UriInfo;

import com.jaeksoft.searchlib.Client;
import com.jaeksoft.searchlib.SearchLibException;
import com.jaeksoft.searchlib.analysis.synonym.SynonymsManager;
import com.jaeksoft.searchlib.webservice.AbstractDirectoryImpl;
import com.jaeksoft.searchlib.webservice.CommonListResult;
import com.jaeksoft.searchlib.webservice.CommonResult;

public class SynonymsImpl implements RestSynonyms {

	private class SynonymsDirectoryImpl extends
			AbstractDirectoryImpl<String, SynonymsManager> {

		@Override
		protected SynonymsManager getManager(Client client)
				throws SearchLibException {
			return client.getSynonymsManager();
		}
	}

	@Override
	public CommonListResult list(UriInfo uriInfo, String index, String login,
			String key) {
		return new SynonymsDirectoryImpl().list(uriInfo, index, login, key);
	}

	@Override
	public CommonResult set(UriInfo uriInfo, String index, String login,
			String key, String name, String content) {
		return new SynonymsDirectoryImpl().set(uriInfo, index, login, key,
				name, content);
	}

	@Override
	public String get(UriInfo uriInfo, String index, String login, String key,
			String name) {
		return new SynonymsDirectoryImpl()
				.get(uriInfo, index, login, key, name);
	}

	@Override
	public CommonResult exists(UriInfo uriInfo, String index, String login,
			String key, String name) {
		return new SynonymsDirectoryImpl().exists(uriInfo, index, login, key,
				name);
	}

	@Override
	public CommonResult delete(UriInfo uriInfo, String index, String login,
			String key, String name) {
		return new SynonymsDirectoryImpl().delete(uriInfo, index, login, key,
				name);
	}

}

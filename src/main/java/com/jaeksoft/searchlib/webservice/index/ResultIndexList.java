/**   
 * License Agreement for OpenSearchServer
 *
 * Copyright (C) 2013-2015 Emmanuel Keller / Jaeksoft
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
package com.jaeksoft.searchlib.webservice.index;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jaeksoft.searchlib.webservice.CommonResult;

@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlRootElement(name = "result")
public class ResultIndexList extends CommonResult {

	@XmlElement(name = "index")
	final public List<String> indexList;

	public ResultIndexList() {
		indexList = null;
	}

	public ResultIndexList(Boolean successful, List<String> indexList) {
		super(successful, indexList.size() + " index(es)");
		this.indexList = indexList;
	}
}

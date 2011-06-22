/*
    Drools5 Integration Helper
    Copyright (C) 2009  Mathieu Boretti mathieu.boretti@gmail.com

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
package com.grandsea.interfaces;

import org.boretti.drools.integration.drools5.annotations.DroolsService;
import java.util.concurrent.Future;

@DroolsService(resourceName="/Customer-interface.cdrl")
public interface CustomerEvaluator {
	public boolean checkCredit(Customer customer);
	
	public Future<Boolean> checkCreditAsync(Customer customer);
}

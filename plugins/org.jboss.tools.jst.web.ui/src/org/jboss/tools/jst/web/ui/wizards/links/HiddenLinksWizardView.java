/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.jst.web.ui.wizards.links;

import org.jboss.tools.common.model.ui.wizards.query.list.AbstractListWizardView;

public class HiddenLinksWizardView extends AbstractListWizardView {

	public HiddenLinksWizardView() {}

	protected String[] getActions() {
		return new String[]{"Hide All", "Show All"};
	}

	protected void internalAction(String command) {
		if("Hide All".equals(command)) {
			for (int i = 0; i < boxes.length; i++) {
				boxes[i].setSelection(false);
				apply(i);
			}
		} else if("Show All".equals(command)) {
			for (int i = 0; i < boxes.length; i++) {
				boxes[i].setSelection(true);
				apply(i);
			}
		}
	}

}
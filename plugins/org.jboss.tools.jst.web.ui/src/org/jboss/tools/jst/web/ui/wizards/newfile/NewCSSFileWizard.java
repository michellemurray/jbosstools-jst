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
package org.jboss.tools.jst.web.ui.wizards.newfile;

import org.jboss.tools.common.model.ui.wizard.newfile.*;

public class NewCSSFileWizard extends NewFileWizardEx {

	protected NewFileContextEx createNewFileContext() {
		return new NewCSSFileContext();
	}
	
	class NewCSSFileContext extends NewFileContextEx {
		protected String getActionPath() {
			return "CreateActions.CreateFiles.Web.CreateFileCSS"; //$NON-NLS-1$
		}
	}
		
}

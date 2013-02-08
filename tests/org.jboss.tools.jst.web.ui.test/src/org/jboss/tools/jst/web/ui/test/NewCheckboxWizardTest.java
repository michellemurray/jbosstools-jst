/******************************************************************************* 
 * Copyright (c) 2013 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.tools.jst.web.ui.test;

import org.eclipse.jface.wizard.IWizardPage;
import org.jboss.tools.jst.web.ui.palette.html.jquery.wizard.JQueryConstants;
import org.jboss.tools.jst.web.ui.palette.html.jquery.wizard.NewCheckBoxWizard;
import org.jboss.tools.jst.web.ui.palette.html.jquery.wizard.NewCheckBoxWizardPage;

/**
 * 
 * @author Viacheslav Kabanovich
 *
 */
public class NewCheckboxWizardTest extends AbstractPaletteEntryTest {
	
	public NewCheckboxWizardTest() {}
	
	public void testNewCheckboxWizard() {
		openEditor("a.html");

		IWizardPage currentPage = runToolEntry("jQuery Mobile", "check box", true);

		assertTrue(currentPage instanceof NewCheckBoxWizardPage);

		NewCheckBoxWizardPage wizardPage = (NewCheckBoxWizardPage)currentPage;
		NewCheckBoxWizard wizard = (NewCheckBoxWizard)wizardPage.getWizard();
		
		String label = "My Favorite Checkbox";
		wizardPage.getEditor(JQueryConstants.EDITOR_ID_LABEL).setValue(label);
		wizardPage.getEditor(JQueryConstants.EDITOR_ID_THEME).setValue("b");
	
		assertTrue(wizard.getTextForBrowser().indexOf(label) > 0);
		assertTrue(wizard.getTextForTextView().indexOf(label) > 0);

		wizardPage.getEditor(JQueryConstants.EDITOR_ID_MINI).setValueAsString("true");
		assertTrue(wizard.getTextForTextView().indexOf(JQueryConstants.ATTR_DATA_MINI + "=\"true\"") > 0);
		wizardPage.getEditor(JQueryConstants.EDITOR_ID_MINI).setValueAsString("false");
		assertTrue(wizard.getTextForTextView().indexOf(JQueryConstants.ATTR_DATA_MINI) < 0);

		wizard.performFinish();

		String text = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput()).get();
		assertTrue(text.indexOf(label) > 0);
	}

}
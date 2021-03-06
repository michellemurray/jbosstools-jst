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
package org.jboss.tools.jst.web.ui.palette.html.jquery.wizard;

import java.beans.PropertyChangeEvent;

import org.eclipse.swt.widgets.Composite;
import org.jboss.tools.common.ui.widget.editor.IFieldEditor;
import org.jboss.tools.jst.web.ui.palette.html.wizard.WizardMessages;

/**
 * 
 * @author Viacheslav Kabanovich
 *
 */
public class NewRadioWizardPage extends NewJQueryWidgetWizardPage {
	RadioEditor buttons = new RadioEditor(this, 1, 8);

	public NewRadioWizardPage() {
		super("newRadio", WizardMessages.newRadioTitle);
		setDescription(WizardMessages.newRadioDescription);
	}

	protected void createFieldPanel(Composite parent) {
		IFieldEditor legend = JQueryFieldEditorFactory.createLegendEditor(WizardDescriptions.radioLegend);
		addEditor(legend, parent);

		createIDEditor(parent, true);

		IFieldEditor layoutEditor = JQueryFieldEditorFactory.createLayoutEditor();
		layoutEditor.setValue(LAYOUT_VERTICAL);
		addEditor(layoutEditor, parent, true);

		Composite panel = buttons.createControl(parent, WizardMessages.itemsLabel);

		IFieldEditor mini = JQueryFieldEditorFactory.createMiniEditor();
		addEditor(mini, panel);

		IFieldEditor iconpos = JQueryFieldEditorFactory.createIconPositionEditor();
		addEditor(iconpos, panel, true);

		IFieldEditor theme = JQueryFieldEditorFactory.createDataThemeEditor();
		addEditor(theme, parent, true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(buttons.isSwitching) {
			return;
		}
		String name = evt.getPropertyName();
		String value = evt.getNewValue().toString();
		if(buttons.onPropertyChange(name, value)) {
			if(EDITOR_ID_CHECKED.equals(name)) {
				buttons.onCheckedModified();
			}
		}

		boolean h = (LAYOUT_HORIZONTAL.equals(getEditorValue(EDITOR_ID_LAYOUT)));
		setEnabled(EDITOR_ID_ICON_POS, !h);

		super.propertyChange(evt);
	}

}

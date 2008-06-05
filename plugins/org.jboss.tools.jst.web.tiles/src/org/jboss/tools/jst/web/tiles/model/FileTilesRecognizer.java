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
package org.jboss.tools.jst.web.tiles.model;

import org.jboss.tools.common.log.LogHelper;
import org.jboss.tools.common.model.loaders.*;
import org.jboss.tools.common.model.plugin.ModelPlugin;
import org.jboss.tools.common.xml.XMLEntityResolver;

public class FileTilesRecognizer implements EntityRecognizer {
    static {
        try {
            XMLEntityResolver.registerPublicEntity(TilesConstants.DOC_PUBLICID, FileTilesRecognizer.class, "/meta/tiles_config_1_1.dtd");
        } catch (Exception e) {
        	ModelPlugin.getPluginLog().logError(e);
        }
    }

    public String getEntityName(String ext, String body) {
        return (body == null || !"xml".equals(ext)) ? null :
               (body.indexOf(TilesConstants.DOC_PUBLICID) >= 0) ? "FileTiles" :
               null;
    }

}

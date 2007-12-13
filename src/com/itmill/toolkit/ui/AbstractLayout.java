/* 
@ITMillApache2LicenseForJavaFiles@
 */

package com.itmill.toolkit.ui;

import com.itmill.toolkit.terminal.PaintException;
import com.itmill.toolkit.terminal.PaintTarget;
import com.itmill.toolkit.terminal.gwt.client.ui.MarginInfo;

/**
 * An abstract class that defines default implementation for the {@link Layout}
 * interface.
 * 
 * @author IT Mill Ltd.
 * @version
 * @VERSION@
 * @since 5.0
 */
public abstract class AbstractLayout extends AbstractComponentContainer
        implements Layout {

    protected MarginInfo margins = new MarginInfo(false, false, false, false);

    /*
     * (non-Javadoc)
     * 
     * @see com.itmill.toolkit.ui.AbstractComponent#getTag()
     */
    public abstract String getTag();

    /*
     * (non-Javadoc)
     * 
     * @see com.itmill.toolkit.ui.Layout#setMargin(boolean)
     */
    public void setMargin(boolean enabled) {
        margins.setMargins(enabled);
        requestRepaint();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.itmill.toolkit.ui.Layout#setMargin(boolean, boolean, boolean,
     *      boolean)
     */
    public void setMargin(boolean topEnabled, boolean rightEnabled,
            boolean bottomEnabled, boolean leftEnabled) {
        margins
                .setMargins(topEnabled, rightEnabled, bottomEnabled,
                        leftEnabled);
        requestRepaint();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.itmill.toolkit.ui.AbstractComponent#paintContent(com.itmill.toolkit.terminal.PaintTarget)
     */
    public void paintContent(PaintTarget target) throws PaintException {

        // Add margin info. Defaults to false.
        target.addAttribute("margins", margins.getBitMask());

    }

}

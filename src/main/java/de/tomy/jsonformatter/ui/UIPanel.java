/**
 * (c) 2012 Thomas- Michael Köper
 * @created Sep 1, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.ui;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class UIPanel extends JPanel
{
    final UIContainer _container = new UIContainer();
    /**
     * Create the panel.
     */
    public UIPanel()
    {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(new FormLayout(new ColumnSpec[] {
                FormFactory.RELATED_GAP_COLSPEC,
                ColumnSpec.decode("pref:grow"),
                FormFactory.RELATED_GAP_COLSPEC,},
                new RowSpec[] {
                FormFactory.RELATED_GAP_ROWSPEC,
                RowSpec.decode("pref:grow"),
                FormFactory.RELATED_GAP_ROWSPEC,}));

        final JTree tree = new JTree();
        _container.setTree(tree);
        add(tree, "2, 2, fill, fill");
    }

    public UIContainer getComponentContainer()
    {
        return _container;
    }
}

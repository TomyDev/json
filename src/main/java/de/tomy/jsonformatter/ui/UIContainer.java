/**
 * (c) 2012 Thomas- Michael Köper
 * @created Sep 1, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.ui;

import javax.swing.JTree;

public class UIContainer
{
    JTree _tree = null;

    public UIContainer()
    {
    }

    public JTree getTree()
    {
        return _tree;
    }

    public void setTree(final JTree tree)
    {
        _tree = tree;
    }

}

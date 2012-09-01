/**
 * (c) 2012 Thomas- Michael Köper
 * @created Aug 31, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.ui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface
{

    private JFrame _window;
    private UIPanel _uiPanel;

    public UserInterface()
    {
    }


    public void buildInterface()
    {
        // Main window
        _window = new JFrame("JSON Formatter");
        _window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        _uiPanel = new UIPanel();
        _window.add(_uiPanel);
        _window.setSize(250,250);
        _window.setVisible(true);
    }

    public UIContainer getContainer()
    {
        return _uiPanel.getComponentContainer();
    }
}

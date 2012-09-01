/**
 * (c) 2012 Thomas- Michael Köper
 * @created Sep 1, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.tree;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;
import javax.swing.tree.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import de.tomy.jsonformatter.json.RootNode;

public class JsonTreeNode implements TreeNode
{
    private final JsonNode _data;
    private final TreeNodeTypes _treeNodeType;
    private final List<TreeNode> _children;
    private final TreeNode _parent;

    public JsonTreeNode(final JsonNode data, final TreeNode parent)
    {
        _data = data;
        _treeNodeType = TreeUtils.getTreeNodeType(data);
        _children = new ArrayList <TreeNode>();
        _parent = parent ;
        if(!(parent instanceof RootNode))fillChildren();
    }
    private void fillChildren()
    {
        if (_treeNodeType.equals(TreeNodeTypes.MutableNode))
        {
            final Iterator <Entry <String, JsonNode>> it = _data.fields();
            while(it.hasNext()) {
                final Entry <String, JsonNode> rawChild = it.next();
                _children.add(new JsonTreeNode(rawChild.getValue(), this));
            }
        }
    }
    public Enumeration <TreeNode> children()
    {
        //TODO : evt mal selbst implementieren , gerade schien mir das am bequemsten
        final Vector<TreeNode> v = new Vector <TreeNode>(_children);
        return v.elements();
    }

    public boolean getAllowsChildren()
    {
        return isLeaf();
    }

    public TreeNode getChildAt(final int arg0)
    {
        return _children.get(arg0);
    }

    public int getChildCount()
    {
        return _children.size();
    }

    public int getIndex(final TreeNode arg0)
    {
        if(_children.contains(arg0)) {
            int index = 0 ;
            for(final TreeNode child : _children) {
                if(child.equals(arg0))
                {
                    return index;
                }
                index ++;
            }
        }
        throw new IllegalArgumentException("Given TreeNode is not a child");
    }

    public TreeNode getParent()
    {
        return _parent;
    }

    public boolean isLeaf()
    {
        return _treeNodeType.equals(TreeNodeTypes.Leaf);
    }

}

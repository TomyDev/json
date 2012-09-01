/**
 * (c) 2012 Thomas- Michael Köper
 * @created Sep 1, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.tree;

import com.fasterxml.jackson.databind.JsonNode;

public class TreeUtils
{
    /**
     * Factory no need to initialize
     */
    private TreeUtils()
    {
    }

    public static TreeNodeTypes getTreeNodeType(final JsonNode node)
    {
        return node.iterator().hasNext() ? TreeNodeTypes.MutableNode : TreeNodeTypes.Leaf;
    }
}

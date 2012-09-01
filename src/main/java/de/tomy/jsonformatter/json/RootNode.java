/**
 * (c) 2012 Thomas- Michael Köper
 * @created Sep 1, 2012
 * @author Köper
 */

package de.tomy.jsonformatter.json;

import java.util.List;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
/**
 *  Nur ein Leerer Dummy zur unterscheidung
 * @author tomy
 *
 */
public class RootNode extends JsonNode
{
    @Override
    public <T extends JsonNode> T deepCopy()
    {
        return null;
    }

    @Override
    public JsonToken asToken()
    {
        return null;
    }

    @Override
    public NumberType numberType()
    {
        return null;
    }

    @Override
    public String asText()
    {
        return null;
    }

    @Override
    public JsonNode findValue(final String fieldName)
    {
        return null;
    }

    @Override
    public JsonNode findPath(final String fieldName)
    {
        return null;
    }

    @Override
    public JsonNode findParent(final String fieldName)
    {
        return null;
    }

    @Override
    public List <JsonNode> findValues(final String fieldName, final List <JsonNode> foundSoFar)
    {
        return null;
    }

    @Override
    public List <String> findValuesAsText(final String fieldName, final List <String> foundSoFar)
    {
        return null;
    }

    @Override
    public List <JsonNode> findParents(final String fieldName, final List <JsonNode> foundSoFar)
    {
        return null;
    }

    @Override
    public JsonNode path(final String fieldName)
    {
        return null;
    }

    @Override
    public JsonNode path(final int index)
    {
        return null;
    }

    @Override
    public JsonParser traverse()
    {
        return null;
    }

    @Override
    public String toString()
    {
        return null;
    }

    @Override
    public boolean equals(final Object o)
    {
        return false;
    }
}

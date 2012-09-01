/**
 * (c) 2012 Thomas- Michael Köper
 * 
 * @created Sep 1, 2012
 * @author Köper
 */
package de.tomy.jsonformatter.json;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.tree.TreeNode;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.tomy.jsonformatter.tree.JsonTreeNode;

public class JsonParser
{
    private List <TreeNode> _nodes;
    private final JsonTreeNode _rootNode;

    public JsonParser(final InputStream is)
    {
        _rootNode = new JsonTreeNode(new RootNode(), null);
        init(is);
    }

    private void init(final InputStream is)
    {
        try
        {
            final ObjectMapper mapper = new ObjectMapper(JsonFactory.class.newInstance());
            final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            final JsonNode tree = mapper.readTree(reader);
            reader.close();
            _nodes = getNodes(tree);
        }
        catch (final JsonProcessingException e)
        {
            e.printStackTrace();
        }
        catch (final InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (final IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (final IOException e)
        {
            e.printStackTrace();
        }
    }

    public TreeNode getRootNode() throws InstantiationException, IllegalAccessException, JsonProcessingException, IOException
    {
        return _rootNode;
    }

    /**
     * Erstellt eine Liste mit TreeNodes aus dem übergebenen Baum
     * 
     * @param tree
     *            Das Ergebniss von mapper.readTree();
     * @return Liste mit JsonTreeNodes aus dem Baum
     */
    private List <TreeNode> getNodes(final JsonNode tree)
    {
        final List <TreeNode> result = new ArrayList <TreeNode>();
        final Iterator <Entry <String, JsonNode>> iterator = tree.fields();
        while (iterator.hasNext())
        {
            final Entry <String, JsonNode> entry = iterator.next();
            System.out.println("Keys: " + entry.getKey());
            //            Wird nicht gebraucht, Node besorgt sich seine Childs selbst - KEIN LAZY LOADING
            //            if (entry.getValue().fields().hasNext())
            //            {
            //                System.out.println("Key has childs : " + entry.getKey());
            //                result.addAll(getNodes(entry.getValue()));
            //            }
            result.add(new JsonTreeNode(entry.getValue(),null ));
        }
        return result;
    }
}

/**
 * (c) 2012 Thomas- Michael Köper
 * @created Aug 31, 2012
 * @author Köper
 */

package de.tomy.jsonformatter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileImporter
{
    /**
     * No need to initialize. Factory!
     */
    private FileImporter()
    {
    }

    /**
     * Liefert den Json String zurück
     * 
     * @param file Die zu öffnende Datei, welche den JSON String enthält
     * @return Json String
     * @throws IOException Wenn es Probleme beim öffnen oder schließen des Dateistreams gibt.
     */
    public static String getStreamByFile(final File file) throws IOException
    {
        if(!file.exists()) throw new IllegalArgumentException("Given Path is not valid.");
        if(file.isDirectory()) throw new IllegalArgumentException("Given file is a Directory.");
        final InputStream fileStream= FileUtils.openInputStream(file);
        final String result =IOUtils.toString(IOUtils.toBufferedInputStream(fileStream));
        fileStream.close();
        return result;
    }
    /**
     * Liefert den Json String zurück
     * 
     * @param path Pfad zur Datei
     * @return Json String
     * @throws IOException Wenn es Probleme beim öffnen oder schließen des Dateistreams gibt.
     */
    public static String getByPath(final String path) throws IOException
    {
        return getStreamByFile(new File(path));
    }
}

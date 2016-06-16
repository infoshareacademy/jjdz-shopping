package com.speed.parsingutils;

import com.speed.model.Category;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by piotr on 10.04.16.
 */
public class ParseXMLTest {

    @Test
    public void willReturnEmptyListWhenParseNullObject() throws XMLStreamException {
        // given
        ParseXML parser = new ParseXML();

        // when
        List<Category> categoryList = parser.parsStax(null);

        // then
        assertEquals(categoryList.size(), 0);
    }

    @Test
    public void willReturnEmptyListWhenParseEmptyFileName() throws XMLStreamException {
        // given
        ParseXML parser = new ParseXML();

        // when
        List<Category> categoryList = parser.parsStax("");

        // then
        assertEquals(categoryList.size(), 0);
    }

    @Test
    public void willReturnEmptyListWhenParseBlankFileName() throws XMLStreamException {
        // given
        ParseXML parser = new ParseXML();

        // when
        List<Category> categoryList = parser.parsStax("      ");

        // then
        assertEquals(categoryList.size(), 0);
    }




    @Test
    public void willReturnCategoriesWhenFileIsValid() throws XMLStreamException {
        // given
        ParseXML parser = new ParseXML();

        // when
        List<Category> categoryList = parser.parsStax("files/validFile.xml");

        System.out.println(categoryList.size());

        // then
        assertTrue(categoryList.size() > 0);

    }



}

/*
 * XML Type:  EntityFilters
 * Namespace: http://schemas.microsoft.com/xrm/2011/Metadata
 * Java type: com.microsoft.schemas.xrm._2011.metadata.EntityFilters
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.metadata.impl;

import java.util.List;
import org.apache.xmlbeans.StringEnumAbstractBase;

/**
 * An XML EntityFilters(@http://schemas.microsoft.com/xrm/2011/Metadata).
 *
 * This is a list type whose items are com.microsoft.schemas.xrm._2011.metadata.EntityFilters$Item.
 */
public class EntityFiltersImpl extends org.apache.xmlbeans.impl.values.XmlListImpl implements com.microsoft.schemas.xrm._2011.metadata.EntityFilters
{
    private static final long serialVersionUID = 1L;

    @Override
    public List<?> listValue() {
        return getListValue();
    }

    @Override
    public List<?> xlistValue() {
        return xgetListValue();
    }

    @Override
    public void set(List<?> list) {
        setListValue(list);
    }
    
    public EntityFiltersImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, false);
    }
    
    protected EntityFiltersImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    /**
     * An anonymous inner XML type.
     *
     * This is an atomic type that is a restriction of com.microsoft.schemas.xrm._2011.metadata.EntityFilters$Item.
     */
    public static class ItemImpl extends org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx implements com.microsoft.schemas.xrm._2011.metadata.EntityFilters.Item
    {
        private static final long serialVersionUID = 1L;

        @Override
        public StringEnumAbstractBase enumValue() {
            return getEnumValue();
        }

        @Override
        public void set(StringEnumAbstractBase e) {
            setEnumValue(e);
        }
        
        public ItemImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType, false);
        }
        
        protected ItemImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
        {
            super(sType, b);
        }
    }
}

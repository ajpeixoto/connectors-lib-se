/*
 * XML Type:  ArrayOfAttributeRequiredLevel
 * Namespace: http://schemas.microsoft.com/xrm/2011/Metadata
 * Java type: com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.metadata;


/**
 * An XML ArrayOfAttributeRequiredLevel(@http://schemas.microsoft.com/xrm/2011/Metadata).
 *
 * This is a complex type.
 */
public interface ArrayOfAttributeRequiredLevel extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfAttributeRequiredLevel.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("arrayofattributerequiredlevel7db8type");
    
    /**
     * Gets array of all "AttributeRequiredLevel" elements
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum[] getAttributeRequiredLevelArray();
    
    /**
     * Gets ith "AttributeRequiredLevel" element
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum getAttributeRequiredLevelArray(int i);
    
    /**
     * Gets (as xml) array of all "AttributeRequiredLevel" elements
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel[] xgetAttributeRequiredLevelArray();
    
    /**
     * Gets (as xml) ith "AttributeRequiredLevel" element
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel xgetAttributeRequiredLevelArray(int i);
    
    /**
     * Returns number of "AttributeRequiredLevel" element
     */
    int sizeOfAttributeRequiredLevelArray();
    
    /**
     * Sets array of all "AttributeRequiredLevel" element
     */
    void setAttributeRequiredLevelArray(com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum[] attributeRequiredLevelArray);
    
    /**
     * Sets ith "AttributeRequiredLevel" element
     */
    void setAttributeRequiredLevelArray(int i, com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum attributeRequiredLevel);
    
    /**
     * Sets (as xml) array of all "AttributeRequiredLevel" element
     */
    void xsetAttributeRequiredLevelArray(com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel[] attributeRequiredLevelArray);
    
    /**
     * Sets (as xml) ith "AttributeRequiredLevel" element
     */
    void xsetAttributeRequiredLevelArray(int i, com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel attributeRequiredLevel);
    
    /**
     * Inserts the value as the ith "AttributeRequiredLevel" element
     */
    void insertAttributeRequiredLevel(int i, com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum attributeRequiredLevel);
    
    /**
     * Appends the value as the last "AttributeRequiredLevel" element
     */
    void addAttributeRequiredLevel(com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel.Enum attributeRequiredLevel);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "AttributeRequiredLevel" element
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel insertNewAttributeRequiredLevel(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "AttributeRequiredLevel" element
     */
    com.microsoft.schemas.xrm._2011.metadata.AttributeRequiredLevel addNewAttributeRequiredLevel();
    
    /**
     * Removes the ith "AttributeRequiredLevel" element
     */
    void removeAttributeRequiredLevel(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel newInstance() {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.metadata.ArrayOfAttributeRequiredLevel) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}

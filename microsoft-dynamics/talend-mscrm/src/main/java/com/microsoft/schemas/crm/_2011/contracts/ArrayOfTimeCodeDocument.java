/*
 * An XML document type.
 * Localname: ArrayOfTimeCode
 * Namespace: http://schemas.microsoft.com/crm/2011/Contracts
 * Java type: com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.crm._2011.contracts;


/**
 * A document containing one ArrayOfTimeCode(@http://schemas.microsoft.com/crm/2011/Contracts) element.
 *
 * This is a complex type.
 */
public interface ArrayOfTimeCodeDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfTimeCodeDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("arrayoftimecode7e4edoctype");
    
    /**
     * Gets the "ArrayOfTimeCode" element
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCode getArrayOfTimeCode();
    
    /**
     * Tests for nil "ArrayOfTimeCode" element
     */
    boolean isNilArrayOfTimeCode();
    
    /**
     * Sets the "ArrayOfTimeCode" element
     */
    void setArrayOfTimeCode(com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCode arrayOfTimeCode);
    
    /**
     * Appends and returns a new empty "ArrayOfTimeCode" element
     */
    com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCode addNewArrayOfTimeCode();
    
    /**
     * Nils the "ArrayOfTimeCode" element
     */
    void setNilArrayOfTimeCode();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument newInstance() {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.crm._2011.contracts.ArrayOfTimeCodeDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}

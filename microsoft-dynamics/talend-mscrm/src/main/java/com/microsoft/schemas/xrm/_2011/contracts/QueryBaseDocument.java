/*
 * An XML document type.
 * Localname: QueryBase
 * Namespace: http://schemas.microsoft.com/xrm/2011/Contracts
 * Java type: com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument
 *
 * Automatically generated - do not modify.
 */
package com.microsoft.schemas.xrm._2011.contracts;


/**
 * A document containing one QueryBase(@http://schemas.microsoft.com/xrm/2011/Contracts) element.
 *
 * This is a complex type.
 */
public interface QueryBaseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(QueryBaseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s7EBB4BC9E00A8FB74293D27D6A5BA466").resolveHandle("querybasedd48doctype");
    
    /**
     * Gets the "QueryBase" element
     */
    com.microsoft.schemas.xrm._2011.contracts.QueryBase getQueryBase();
    
    /**
     * Tests for nil "QueryBase" element
     */
    boolean isNilQueryBase();
    
    /**
     * Sets the "QueryBase" element
     */
    void setQueryBase(com.microsoft.schemas.xrm._2011.contracts.QueryBase queryBase);
    
    /**
     * Appends and returns a new empty "QueryBase" element
     */
    com.microsoft.schemas.xrm._2011.contracts.QueryBase addNewQueryBase();
    
    /**
     * Nils the "QueryBase" element
     */
    void setNilQueryBase();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    static final class StaticFactory
    {
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument newInstance() {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.microsoft.schemas.xrm._2011.contracts.QueryBaseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        private StaticFactory() { } // No instance of this class allowed
    }
}

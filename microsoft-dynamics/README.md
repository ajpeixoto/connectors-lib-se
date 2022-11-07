# Microsoft Dynamics Talend library
This folder contains a library to support communication with Microsoft dynamics and used by Talend tMicrosoftCrmXXX
connectors in the studio, and the dynamics-crm TCK connector.

The library has been duplicated in two version:
* talend-mscrm : The last version of the library that has migrated to msal4j
* talend-mscrm-studio-7.3 : the compatible version for studio/7.3 that still use adal4j

Before 8.0.1-R202211 studio release, the library was hosted in [tdi-studio-se](https://github.com/Talend/tdi-studio-se/tree/release/8.0.1-R2022-10/main/plugins/org.talend.designer.components.libs/libs_src/talend-mscrm).
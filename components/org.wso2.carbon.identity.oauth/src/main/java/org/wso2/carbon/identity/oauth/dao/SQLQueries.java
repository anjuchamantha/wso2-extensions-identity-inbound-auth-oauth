/*
 * Copyright (c) 2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oauth.dao;

/**
 * SQL queries related to OAuth data access layer.
 */
public class SQLQueries {
    private SQLQueries(){

    }

    public static class OAuthAppDAOSQLQueries {

        public static final String ADD_OAUTH_APP = "INSERT INTO IDN_OAUTH_CONSUMER_APPS " +
                "(CONSUMER_KEY, CONSUMER_SECRET, USERNAME, TENANT_ID, USER_DOMAIN, APP_NAME, OAUTH_VERSION," +
                " CALLBACK_URL, GRANT_TYPES, USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME," +
                " REFRESH_TOKEN_EXPIRE_TIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";

        public static final String ADD_OAUTH_APP_WITH_PKCE = "INSERT INTO IDN_OAUTH_CONSUMER_APPS " +
                "(CONSUMER_KEY, CONSUMER_SECRET, USERNAME, TENANT_ID, USER_DOMAIN, APP_NAME, OAUTH_VERSION, " +
                "CALLBACK_URL, GRANT_TYPES, PKCE_MANDATORY, PKCE_SUPPORT_PLAIN, USER_ACCESS_TOKEN_EXPIRE_TIME, " +
                "APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        public static final String ADD_OAUTH_APP_WITH_AUDIENCES = "INSERT INTO IDP_OIDC_PROPERTY " +
                "(TENANT_ID, CONSUMER_KEY, PROPERTY_KEY, PROPERTY_VALUE) " +
                "VALUES (?,?,?,?) ";

        public static final String ADD_OAUTH_CONSUMER = "INSERT INTO IDN_OAUTH_CONSUMER_APPS " +
                "(CONSUMER_KEY, CONSUMER_SECRET, USERNAME, TENANT_ID, USER_DOMAIN, OAUTH_VERSION, " +
                "USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME) " +
                "VALUES (?,?,?,?,?,?,?,?,?) ";

        public static final String UPDATE_OAUTH_CONSUMER = "UPDATE IDN_OAUTH_CONSUMER_APPS " +
                "SET CONSUMER_SECRET=? WHERE CONSUMER_KEY=? AND USERNAME=? AND TENANT_ID=? AND USER_DOMAIN=?";

        public static final String GET_APPS_OF_USER = "SELECT CONSUMER_KEY, CONSUMER_SECRET, APP_NAME, OAUTH_VERSION," +
                " CALLBACK_URL, GRANT_TYPES, ID, USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME," +
                " REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS WHERE USERNAME=? AND TENANT_ID=? AND USER_DOMAIN=?";

        public static final String GET_APPS_OF_USER_WITH_TENANTAWARE_OR_TENANTUNAWARE_USERNAME = "SELECT " +
                "CONSUMER_KEY, CONSUMER_SECRET, APP_NAME, OAUTH_VERSION, CALLBACK_URL, GRANT_TYPES, ID, USERNAME," +
                " TENANT_ID ,USER_DOMAIN, USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME," +
                " REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS WHERE (USERNAME=? OR USERNAME=?) AND TENANT_ID=?";

        public static final String GET_APPS_OF_USER_WITH_TENANTAWARE_OR_TENANTUNAWARE_USERNAME_WITH_PKCE = "SELECT " +
                "CONSUMER_KEY, CONSUMER_SECRET, APP_NAME, OAUTH_VERSION, CALLBACK_URL, GRANT_TYPES, ID, USERNAME, TENANT_ID, " +
                "USER_DOMAIN, PKCE_MANDATORY, PKCE_SUPPORT_PLAIN, USER_ACCESS_TOKEN_EXPIRE_TIME, " +
                "APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS" +
                " WHERE (USERNAME=? OR USERNAME=?) AND TENANT_ID=?";

        public static final String GET_CONSUMER_APPS_OF_USER = "SELECT " +
                "CONSUMER_KEY, CONSUMER_SECRET, APP_NAME, OAUTH_VERSION, CALLBACK_URL, GRANT_TYPES, ID, USERNAME," +
                " TENANT_ID ,USER_DOMAIN, USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME," +
                " REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS WHERE USERNAME=? AND USER_DOMAIN=? AND TENANT_ID=?";

        public static final String GET_CONSUMER_APPS_OF_USER_WITH_PKCE = "SELECT " +
                "CONSUMER_KEY, CONSUMER_SECRET, APP_NAME, OAUTH_VERSION, CALLBACK_URL, GRANT_TYPES, ID, USERNAME, TENANT_ID, " +
                "USER_DOMAIN, PKCE_MANDATORY, PKCE_SUPPORT_PLAIN, USER_ACCESS_TOKEN_EXPIRE_TIME, " +
                "APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS" +
                " WHERE USERNAME=? AND USER_DOMAIN=? AND TENANT_ID=?";

        public static final String GET_APP_INFO = "SELECT CONSUMER_SECRET, USERNAME, APP_NAME, OAUTH_VERSION, " +
                "CALLBACK_URL, TENANT_ID, USER_DOMAIN, GRANT_TYPES, ID, USER_ACCESS_TOKEN_EXPIRE_TIME," +
                " APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS" +
                " WHERE CONSUMER_KEY=? ";

        public static final String GET_APP_INFO_WITH_PKCE = "SELECT CONSUMER_SECRET,USERNAME,APP_NAME, OAUTH_VERSION, " +
                "CALLBACK_URL,TENANT_ID, USER_DOMAIN, GRANT_TYPES, ID, PKCE_MANDATORY, PKCE_SUPPORT_PLAIN, " +
                "USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME" +
                " FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=? ";

        public static final String GET_AUDIENCE_VALUES = "SELECT PROPERTY_VALUE FROM IDP_OIDC_PROPERTY WHERE TENANT_ID = ? AND CONSUMER_KEY = ? AND PROPERTY_KEY = ?";

        public static final String GET_AUDIENCE_VALUES_BY_APP_NAME = "SELECT PROPERTY_VALUE FROM IDP_OIDC_PROPERTY WHERE TENANT_ID = ? " +
                "AND CONSUMER_KEY = (SELECT CONSUMER_KEY FROM IDN_OAUTH_CONSUMER_APPS WHERE TENANT_ID = ? AND APP_NAME =?) AND PROPERTY_KEY = ?";

        public static final String GET_APP_INFO_BY_APP_NAME = "SELECT CONSUMER_SECRET, USERNAME, USER_DOMAIN, CONSUMER_KEY, " +
                "OAUTH_VERSION, CALLBACK_URL, GRANT_TYPES, ID, USER_ACCESS_TOKEN_EXPIRE_TIME, APP_ACCESS_TOKEN_EXPIRE_TIME," +
                " REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS WHERE APP_NAME=? AND TENANT_ID=? ";

        public static final String GET_APP_INFO_BY_APP_NAME_WITH_PKCE = "SELECT CONSUMER_SECRET,USERNAME,USER_DOMAIN,CONSUMER_KEY, " +
                "OAUTH_VERSION, CALLBACK_URL,GRANT_TYPES, ID, PKCE_MANDATORY, PKCE_SUPPORT_PLAIN, USER_ACCESS_TOKEN_EXPIRE_TIME," +
                " APP_ACCESS_TOKEN_EXPIRE_TIME, REFRESH_TOKEN_EXPIRE_TIME FROM IDN_OAUTH_CONSUMER_APPS " +
                "WHERE APP_NAME=? AND TENANT_ID=? ";

        public static final String UPDATE_CONSUMER_APP = "UPDATE IDN_OAUTH_CONSUMER_APPS SET APP_NAME=?," +
                " CALLBACK_URL=?, GRANT_TYPES=?, USER_ACCESS_TOKEN_EXPIRE_TIME=?, " +
                "APP_ACCESS_TOKEN_EXPIRE_TIME=?, REFRESH_TOKEN_EXPIRE_TIME=? " +
                "WHERE CONSUMER_KEY=? AND CONSUMER_SECRET=?";

        public static final String UPDATE_CONSUMER_APP_WITH_PKCE = "UPDATE IDN_OAUTH_CONSUMER_APPS SET APP_NAME=?," +
                " CALLBACK_URL=?, GRANT_TYPES=?, PKCE_MANDATORY=?, PKCE_SUPPORT_PLAIN=?, " +
                "USER_ACCESS_TOKEN_EXPIRE_TIME=?, APP_ACCESS_TOKEN_EXPIRE_TIME=?, " +
                "REFRESH_TOKEN_EXPIRE_TIME=? WHERE CONSUMER_KEY=? AND CONSUMER_SECRET=?";

        public static final String CHECK_EXISTING_APPLICATION = "SELECT * FROM IDN_OAUTH_CONSUMER_APPS " +
                "WHERE USERNAME=? AND TENANT_ID=? AND USER_DOMAIN=? AND APP_NAME=?";

        public static final String CHECK_EXISTING_CONSUMER = "SELECT * FROM IDN_OAUTH_CONSUMER_APPS " +
                "WHERE CONSUMER_KEY=?";

        public static final String GET_APP_NAME = "SELECT APP_NAME FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=?";

        public static final String REMOVE_APPLICATION = "DELETE FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=?";

        public static final String REMOVE_OIDC_PROPERTIES = "DELETE FROM IDP_OIDC_PROPERTY WHERE TENANT_ID=? AND CONSUMER_KEY=?";

        public static final String REMOVE_AUDIENCE_VALUE ="DELETE FROM IDP_OIDC_PROPERTY WHERE TENANT_ID=? " +
                "AND CONSUMER_KEY=? AND PROPERTY_KEY=? AND PROPERTY_VALUE=?";

        public static final String UPDATE_OAUTH_INFO = "UPDATE IDN_OAUTH_CONSUMER_APPS SET APP_NAME=? WHERE " +
                "CONSUMER_KEY=?";

        public static final String UPDATE_OAUTH_SECRET_KEY = "UPDATE IDN_OAUTH_CONSUMER_APPS SET CONSUMER_SECRET=? WHERE " +
                "CONSUMER_KEY=?";

        public static final String GET_APPLICATION_STATE = "SELECT APP_STATE FROM IDN_OAUTH_CONSUMER_APPS WHERE " +
                "CONSUMER_KEY=?";

        public static final String UPDATE_APPLICATION_STATE = "UPDATE IDN_OAUTH_CONSUMER_APPS SET APP_STATE=? WHERE " +
                "CONSUMER_KEY=?";

        private OAuthAppDAOSQLQueries() {
        }
    }

    public static class OAuthConsumerDAOSQLQueries {
        public static final String GET_CONSUMER_SECRET = "SELECT CONSUMER_SECRET FROM IDN_OAUTH_CONSUMER_APPS " +
                "WHERE CONSUMER_KEY=?";

        public static final String GET_REGISTERED_CALLBACK_URL = "SELECT CALLBACK_URL FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=?";

        public static final String ADD_OAUTH_REQ_TOKEN = "INSERT INTO IDN_OAUTH1A_REQUEST_TOKEN (REQUEST_TOKEN, REQUEST_TOKEN_SECRET, CONSUMER_KEY_ID, CALLBACK_URL, SCOPE, AUTHORIZED) SELECT ?,?,ID,?,?,? FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=?";

        public static final String GET_CALLBACK_URL_OF_REQ_TOKEN = "SELECT CALLBACK_URL FROM IDN_OAUTH1A_REQUEST_TOKEN WHERE REQUEST_TOKEN=?";

        public static final String AUTHORIZE_REQ_TOKEN = "UPDATE IDN_OAUTH1A_REQUEST_TOKEN SET AUTHORIZED=?, OAUTH_VERIFIER=?, AUTHZ_USER=? " +
                "WHERE REQUEST_TOKEN=?";

        public static final String GET_REQ_TOKEN = "SELECT * FROM IDN_OAUTH1A_REQUEST_TOKEN WHERE REQUEST_TOKEN=?";

        public static final String GET_REQ_TOKEN_SECRET = "SELECT REQUEST_TOKEN_SECRET FROM IDN_OAUTH1A_REQUEST_TOKEN WHERE REQUEST_TOKEN=?";

        public static final String REMOVE_REQUEST_TOKEN = "DELETE FROM IDN_OAUTH1A_REQUEST_TOKEN WHERE REQUEST_TOKEN=?";

        public static final String ADD_ACCESS_TOKEN = "INSERT INTO IDN_OAUTH1A_ACCESS_TOKEN VALUES (?,?,?,?,?)";

        public static final String GET_ACCESS_TOKEN = "SELECT SCOPE, AUTHZ_USER FROM IDN_OAUTH1A_ACCESS_TOKEN " +
                "WHERE ACCESS_TOKEN=?";

        public static final String GET_ACCESS_TOKEN_SECRET = "SELECT ACCESS_TOKEN_SECRET FROM IDN_OAUTH1A_ACCESS_TOKEN " +
                "WHERE ACCESS_TOKEN=?";

        public static final String GET_CONSUMER_KEY_FOR_TOKEN = "SELECT CONSUMER_KEY, SCOPE FROM " +
                "IDN_OAUTH_CONSUMER_APPS JOIN (SELECT CONSUMER_KEY_ID, SCOPE FROM IDN_OAUTH1A_REQUEST_TOKEN WHERE " +
                "REQUEST_TOKEN=?) AS REQUEST_TOKEN_TABLE_SELECTED ON IDN_OAUTH_CONSUMER_APPS.ID = " +
                "REQUEST_TOKEN_TABLE_SELECTED.CONSUMER_KEY_ID";

        // Get the username corresponding to the given consumer key and secret
        public static final String GET_USERNAME_FOR_KEY_AND_SECRET = "SELECT USERNAME FROM IDN_OAUTH_CONSUMER_APPS WHERE CONSUMER_KEY=? AND CONSUMER_SECRET=?";

        private OAuthConsumerDAOSQLQueries(){

        }
    }
}

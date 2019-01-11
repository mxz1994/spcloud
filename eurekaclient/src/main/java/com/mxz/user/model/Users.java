package com.mxz.user.model;

import java.util.List;

public class Users {

    private List<HintsBean> hints;
    private List<GroupsBean> groups;
    private List<PropertiesBean> properties;

    public List<HintsBean> getHints() {
        return hints;
    }

    public void setHints(List<HintsBean> hints) {
        this.hints = hints;
    }

    public List<GroupsBean> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupsBean> groups) {
        this.groups = groups;
    }

    public List<PropertiesBean> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertiesBean> properties) {
        this.properties = properties;
    }

    public static class HintsBean {
        /**
         * values : [{"value":"*"}]
         * name : management.endpoints.web.cors.allowed-headers
         * providers : [{"name":"any"}]
         */

        private String name;
        private List<ValuesBean> values;
        private List<ProvidersBean> providers;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ValuesBean> getValues() {
            return values;
        }

        public void setValues(List<ValuesBean> values) {
            this.values = values;
        }

        public List<ProvidersBean> getProviders() {
            return providers;
        }

        public void setProviders(List<ProvidersBean> providers) {
            this.providers = providers;
        }

        public static class ValuesBean {
            /**
             * value : *
             */

            private String value;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class ProvidersBean {
            /**
             * name : any
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class GroupsBean {
        /**
         * sourceType : org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpoint
         * name : management.endpoint.conditions
         * type : org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpoint
         * sourceMethod : getExposure()
         */

        private String sourceType;
        private String name;
        private String type;
        private String sourceMethod;

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSourceMethod() {
            return sourceMethod;
        }

        public void setSourceMethod(String sourceMethod) {
            this.sourceMethod = sourceMethod;
        }
    }

    public static class PropertiesBean {
        /**
         * deprecated : true
         * name : endpoints.actuator.enabled
         * description : Whether to enable the endpoint.
         * type : java.lang.Boolean
         * deprecation : {"reason":"The \"actuator\" endpoint is no longer available.","level":"error"}
         * defaultValue : 1800
         * sourceType : org.springframework.boot.actuate.autoconfigure.condition.ConditionsReportEndpoint
         */

        private boolean deprecated;
        private String name;
        private String description;
        private String type;
        private DeprecationBean deprecation;
        private int defaultValue;
        private String sourceType;

        public boolean isDeprecated() {
            return deprecated;
        }

        public void setDeprecated(boolean deprecated) {
            this.deprecated = deprecated;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DeprecationBean getDeprecation() {
            return deprecation;
        }

        public void setDeprecation(DeprecationBean deprecation) {
            this.deprecation = deprecation;
        }

        public int getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(int defaultValue) {
            this.defaultValue = defaultValue;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public static class DeprecationBean {
            /**
             * reason : The "actuator" endpoint is no longer available.
             * level : error
             */

            private String reason;
            private String level;

            public String getReason() {
                return reason;
            }

            public void setReason(String reason) {
                this.reason = reason;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }
        }
    }
}

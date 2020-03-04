/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.enhanced.dynamodb.mapper.testbeans;

import java.util.List;
import java.util.Objects;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class EnumBean {
    private String id;
    private TestEnum testEnum;
    private List<TestEnum> testEnumList;

    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestEnum getTestEnum() {
        return testEnum;
    }

    public void setTestEnum(TestEnum testEnum) {
        this.testEnum = testEnum;
    }

    public List<TestEnum> getTestEnumList() {
        return testEnumList;
    }

    public void setTestEnumList(List<TestEnum> testEnumList) {
        this.testEnumList = testEnumList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnumBean enumBean = (EnumBean) o;

        if (id != null ? !id.equals(enumBean.id) : enumBean.id != null) return false;
        if (testEnum != enumBean.testEnum) return false;
        return testEnumList != null ? testEnumList.equals(enumBean.testEnumList) : enumBean.testEnumList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (testEnum != null ? testEnum.hashCode() : 0);
        result = 31 * result + (testEnumList != null ? testEnumList.hashCode() : 0);
        return result;
    }

    public enum TestEnum {
        ONE,
        TWO,
        THREE;
    }
}

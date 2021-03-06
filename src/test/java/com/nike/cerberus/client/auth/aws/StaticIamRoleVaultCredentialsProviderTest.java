/*
 * Copyright (c) 2017 Nike, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nike.cerberus.client.auth.aws;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.nike.vault.client.StaticVaultUrlResolver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticIamRoleVaultCredentialsProviderTest {

    private static final String ACCOUNT_ID = "1234";
    private static final String ROLE_NAME = "foo/base/bar";
    private static final String ROLE_ARN = String.format("arn:aws:iam::%s:role/%s", ACCOUNT_ID, ROLE_NAME);
    private static final String REGION_STRING = "us-west-2";
    private static final Region REGION = Region.getRegion(Regions.US_WEST_2);

    @Test
    public void test_constructor_1() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
              new StaticVaultUrlResolver("foo"),
              ACCOUNT_ID,
              ROLE_NAME,
              REGION_STRING
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_2() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                "foo",
                ACCOUNT_ID,
                ROLE_NAME,
                REGION_STRING
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_3() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                new StaticVaultUrlResolver("foo"),
                ACCOUNT_ID,
                ROLE_NAME,
                REGION
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_4() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                "foo",
                ACCOUNT_ID,
                ROLE_NAME,
                REGION
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_5() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                new StaticVaultUrlResolver("foo"),
                ROLE_ARN,
                REGION_STRING
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_6() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                "foo",
                ROLE_ARN,
                REGION_STRING
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_7() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                new StaticVaultUrlResolver("foo"),
                ROLE_ARN,
                REGION
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

    @Test
    public void test_constructor_8() {
        StaticIamRoleVaultCredentialsProvider provider = new StaticIamRoleVaultCredentialsProvider(
                "foo",
                ROLE_ARN,
                REGION
        );

        assertEquals(ROLE_ARN, provider.iamPrincipalArn);
        assertEquals(REGION, provider.region);
    }

}

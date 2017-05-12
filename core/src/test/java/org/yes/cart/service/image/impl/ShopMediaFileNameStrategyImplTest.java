/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.service.image.impl;

import org.junit.Before;
import org.junit.Test;
import org.yes.cart.BaseCoreDBTestCase;
import org.yes.cart.constants.Constants;
import org.yes.cart.constants.ServiceSpringKeys;
import org.yes.cart.service.image.MediaFileNameStrategy;

import static org.junit.Assert.assertEquals;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class ShopMediaFileNameStrategyImplTest extends BaseCoreDBTestCase {

    private MediaFileNameStrategy mediaFileNameStrategy;

    @Before
    public void setUp() {
        mediaFileNameStrategy = (MediaFileNameStrategy) ctx().getBean(ServiceSpringKeys.SHOP_IMAGE_NAME_STRATEGY);
        super.setUp();
    }


    @Test
    public void testGetCodeFromActualObject() {

        //test case to support file names without shop name code
        assertEquals("SHOIP1", mediaFileNameStrategy.resolveObjectCode("shoip1.jpeg"));
        assertEquals("SHOIP1", mediaFileNameStrategy.resolveObjectCode("imgvault/shop/shoip1.jpeg"));
        assertEquals("SHOIP1", mediaFileNameStrategy.resolveObjectCode("imgvault/shop/shoip1.jpeg?w=10&h=4"));

        // test that inexistent are resolved to no image
        assertEquals(Constants.NO_IMAGE, mediaFileNameStrategy.resolveObjectCode("imgvault/shop/unknown-shop.jpeg"));

    }

}
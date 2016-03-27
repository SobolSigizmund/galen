/*******************************************************************************
* Copyright 2016 Ivan Shubin http://galenframework.com
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*   http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
******************************************************************************/
package com.galenframework.tests.action;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.io.IOException;

import com.galenframework.browser.Browser;
import com.galenframework.browser.SeleniumBrowser;
import com.galenframework.components.mocks.driver.MockedDriver;
import com.galenframework.reports.TestReport;
import com.galenframework.suite.GalenPageTest;
import com.galenframework.suite.actions.GalenPageActionInjectJavascript;
import com.galenframework.browser.Browser;
import com.galenframework.browser.SeleniumBrowser;
import com.galenframework.components.mocks.driver.MockedDriver;
import com.galenframework.reports.TestReport;
import com.galenframework.suite.GalenPageTest;
import com.galenframework.suite.actions.GalenPageActionInjectJavascript;
import org.testng.annotations.Test;

public class GalenPageActionInjectJavascriptTest {

    @Test public void shouldInject_javascript() throws IOException {
        MockedDriver driver = new MockedDriver();
        Browser browser = new SeleniumBrowser(driver);

        GalenPageActionInjectJavascript action = new GalenPageActionInjectJavascript("/scripts/to-inject-1.js");
        action.execute(new TestReport(), browser, new GalenPageTest(), null);
        
        assertThat("injected script should be",
                driver.getAllExecutedJavascript(),
                contains("$(\"body\").append(\"<injected-tag>Some injected content</injected-tag>\");"));
    }
}

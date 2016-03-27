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
package com.galenframework.speclang2.specs;

import com.galenframework.parser.SyntaxException;
import com.galenframework.specs.Spec;
import com.galenframework.parser.StringCharReader;

public abstract class SingleWordSpecProcessor implements SpecProcessor {

    public abstract Spec createSpec();

    @Override
    public Spec process(StringCharReader reader, String contextPath) {
        String theRest = reader.getTheRest().trim();
        if (!theRest.isEmpty()) {
            throw new SyntaxException("This spec doesn't take any arguments");
        }
        return createSpec();
    }
}

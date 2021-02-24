/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Red Hat, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.resourcedisposer.Disposable.State.Thrown

import hudson.Functions

def st = namespace("jelly:stapler")
st.once {
    style {
        text(
                """
                    .stacktrace {
                        position: relative;
                    }
                    .stacktrace .short {
                        display: block;
                        text-decoration: underline dotted;
                    }
                    .stacktrace .full {
                        visibility: hidden;
                        position: absolute;
                        background: var(--light-bg-color, #ddd);

                        top: -5px; left: -4px;
                        border: solid 1px #bbb;
                        padding: 4px 3px;
                        z-index: 100;
                    }
                    .stacktrace:hover .full {
                        visibility: visible;
                    }
                """
        )
    }
}

def stacktrace = Functions.printThrowable(my.cause)
pre(class: "stacktrace") {
    div(class: "full") {
        text(stacktrace)
    }
    div(class: "short") {
        text(my.cause.toString())
    }
}

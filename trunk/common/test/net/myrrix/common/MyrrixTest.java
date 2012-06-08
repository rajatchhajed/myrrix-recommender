/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.myrrix.common;

import java.io.File;

import com.google.common.io.Files;
import org.apache.mahout.common.RandomUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public abstract class MyrrixTest extends Assert {

  protected static final double EPSILON = 1.0e-6; // appropriate for float

  private File testTempDir;

  @Before
  public synchronized void setUp() throws Exception {
    testTempDir = null;
    RandomUtils.useTestSeed();
  }

  @After
  public synchronized void tearDown() throws Exception {
    IOUtils.deleteRecursively(testTempDir);
  }

  protected final synchronized File getTestTempDir() {
    if (testTempDir == null) {
      testTempDir = Files.createTempDir();
      testTempDir.deleteOnExit();
    }
    return testTempDir;
  }

}

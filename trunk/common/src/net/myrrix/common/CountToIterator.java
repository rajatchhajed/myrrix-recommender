/*
 * Copyright Myrrix Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.myrrix.common;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterates over the range [0,max).
 *
 * @author Sean Owen
 */
public final class CountToIterator implements Iterator<Integer> {
  
  private int count;
  private final int max;
  
  public CountToIterator(int max) {
    this.max = max;
  }

  @Override
  public boolean hasNext() {
    return count < max;
  }

  @Override
  public Integer next() {
    if (count >= max) {
      throw new NoSuchElementException();
    }
    return count++;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

}

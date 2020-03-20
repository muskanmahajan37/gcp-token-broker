// Copyright 2020 Google LLC
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.broker.caching.remote;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.google.cloud.broker.checks.CheckResult;

/**
 * Dummy caching backend that does not actually cache anything.
 * Use only for testing. Do NOT use in production!
 */

public class DummyCache extends AbstractRemoteCache {

    @Override
    public byte[] get(String key) {
        return null;
    }

    @Override
    public void set(String key, byte[] value) {
    }

    @Override
    public void set(String key, byte[] value, int expireIn) {
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public Lock acquireLock(String lockName) {
        return new NoOpLock();
    }

    @Override
    public CheckResult checkConnection() {
        return new CheckResult(true);
    }

    public static class NoOpLock implements Lock {

        @Override
        public void lock() {

        }

        @Override
        public void lockInterruptibly() throws InterruptedException {

        }

        @Override
        public boolean tryLock() {
            return true;
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return true;
        }

        @Override
        public void unlock() {

        }

        @Override
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }

}

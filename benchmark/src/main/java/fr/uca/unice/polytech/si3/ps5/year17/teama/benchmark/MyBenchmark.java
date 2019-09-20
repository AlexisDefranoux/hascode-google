/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package fr.uca.unice.polytech.si3.ps5.year17.teama.benchmark;

import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.ControllerState;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.InputSplitter;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.Score;
import fr.uca.unice.polytech.si3.ps5.year17.teama.engine.strategy.Strategy;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static fr.uca.unice.polytech.si3.ps5.year17.teama.engine.Main.useStrategy;

@State(Scope.Benchmark)
public class MyBenchmark {
    private ControllerState controllerState;
    private File file;


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra1() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(1, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra2() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(2, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra3() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(3, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra4() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(4, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra5() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(5, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra6() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(6, controllerState);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra7() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(7, controllerState);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(1)
    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS) // 10 warm up iterations without measures
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    public void useStra8() {
        controllerState = new ControllerState();
        try {
            controllerState = InputSplitter.Lecture(controllerState, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        useStrategy(8, controllerState);
    }

    @Setup
    public  void main( ) throws IOException {

        String pathDataIn = Paths.get("").toAbsolutePath().toString();
        file = new File(pathDataIn,"..");
        file = new File(file,"data");
        file = new File(file,"kitten.in");
     }

}

Android cognitive test battery
=================================

The Android cognitive test battery is a suite of cognitive tests for android. The goal of this project is to provide standardized, easy to use cognitive tests for ambulatory assessment. The test use black background to reduce the demand on the eye.

### Implemented cognitive Tests ###
Currently these tests are not yet validated!

 * Psychomotor Vigilance Task (PVT)
 * DualNBack
 * More to come. Please commit pull request to add more characteristics.

### Usage ###

There are three use cases:

 * Download and test the Cognitive battery app in the Play Store (not available yet)
 * Use the cognitive tests in your own application by calling the Cognitive battery app by calling the actions:

        com.movisens.xs.android.cognition.PVT
 
 or include the library and start the Activity:

        com.movisens.xs.android.cognition.pvt.PVT

 * Use the default or customized cognitive tests in [movisensXS](http://xs.movisens.com)

### Attribution ###

If you use one of the test in your studie, please cite the appropriate articles:

#### PVT ####

 * Matthew Kay, Kyle Rector, Sunny Consolvo, Ben Greenstein, Jacob O. Wobbrock, Nathaniel F. Watson, and Julie A. Kientz (2013). PVT-Touch: adapting a reaction time test for touchscreen devices, in Proceedings of PervasiveHealth 2013: Conference on pervasive computing technologies for healthcare.
 * Matthew Kay, Michael Grandner, Jared Bauer, Rebecca Lang, Nathaniel F. Watson, and Julie A. Kientz (2013). Initial validation of an Android-based psychomotor vigilance task, in Sleep 36: Abstract supplement, A108.

### License ###
Copyright 2013 movisens GmbH

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
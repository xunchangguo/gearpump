/*
 * Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gearpump.streaming.source

import java.time.Instant

import io.gearpump.Time
import io.gearpump.Message

/**
 * message used by source task to report source watermark.
 */
case class Watermark(instant: Instant) {
  def toMessage: Message = Message("watermark", instant)
}

/**
 * All input data with event times less than watermark have been observed
 */
object Watermark {

  // all input data have been observed
  val MAX: Instant = Instant.ofEpochMilli(Time.MAX_TIME_MILLIS + 1)

  // no input data have been observed
  val MIN: Instant = Instant.ofEpochMilli(Time.MIN_TIME_MILLIS)
}
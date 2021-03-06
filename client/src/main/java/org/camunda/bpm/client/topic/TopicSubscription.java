/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.client.topic;

import org.camunda.bpm.client.task.ExternalTaskHandler;

import java.util.List;

/**
 * <p>Subscription to a topic</p>
 *
 * @author Tassilo Weidner
 */
public interface TopicSubscription {

  /**
   * The client has been unsubscribed from the topic.
   * NB! It can happen, that the changes are not applied immediately, in case the client is currently iterating over the bunch of fetched and locked external tasks.
   * The changes will have affect starting from the next bunch only.
   */
  void close();

  /**
   * @return the topic name of the subscription
   */
  String getTopicName();

  /**
   * @return <ul>
   *           <li> the duration of the lock applied to the topic
   *           <li> if {@code null}, the client or the default lock duration is applied
   *         </ul>
   */
  Long getLockDuration();

  /**
   * @return the external task handler of the topic
   */
  ExternalTaskHandler getExternalTaskHandler();

  /**
   * @return a list of variable names which are supposed to be retrieved
   */
  List<String> getVariableNames();

  /**
   * @return the business key associated with the external tasks which are supposed to be fetched and locked
   */
  String getBusinessKey();

}

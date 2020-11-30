package com.lewzerb.leetcode.s0101_0200;

public class Leetcode0182 {
/**
 * # Write your MySQL query statement below
 * select Email from (
 * select Email, count(Id) as cnt
 * from Person
 * group by Email
 * ) b where b.cnt > 1;
 */

/**
 * select Email
 * from Person
 * group by Email
 * having count(Email) > 1;
 */
}

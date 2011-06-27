#!/usr/bin/env ruby

f = File.open("config")

config = {}

f.each_line do |l|
  k, v = l.split('=')
  config[k] = v
end

config


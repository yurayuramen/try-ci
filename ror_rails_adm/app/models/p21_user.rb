class P21User < ApplicationRecord
  establish_connection :dev01
  has_many :p21_groups
end

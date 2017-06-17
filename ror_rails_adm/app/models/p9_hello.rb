class P9Hello < ApplicationRecord
  validates :name, uniqueness: true
end

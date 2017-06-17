class P21Group < ApplicationRecord
  establish_connection :dev01
  belongs_to :p21_user

end

class P5UseImg < ApplicationRecord
  mount_uploader :image1, AvatarUploader
  mount_uploader :image2, AvatarUploader
  mount_uploader :gcs, GoogleUploader
end

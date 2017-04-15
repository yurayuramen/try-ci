CarrierWave.configure do |config|
  config.storage                             = :gcloud
  config.gcloud_bucket                       = 'rr-test-2017'
  config.gcloud_bucket_is_public             = true
  config.gcloud_authenticated_url_expiration = 600
  
  config.gcloud_attributes = {
    expires: 600
  }
  
  config.gcloud_credentials = {
    gcloud_project: 'spatial-framing-163309',
    gcloud_keyfile: '/usr/src/app/config/environments/gcs-account-03.json'
    # gcloud_keyfile: '/usr/src/app/config/environments/gcs-secret.json'
  }
end

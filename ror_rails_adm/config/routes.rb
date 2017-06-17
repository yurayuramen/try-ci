Rails.application.routes.draw do
  mount Ckeditor::Engine => '/ckeditor'
  get 'p9_out/index'
  get "admin/:x/:y/uploads/ckeditor/pictures/:id/content_:file.:ext" => redirect("https://storage.googleapis.com/rr-test-2017/uploads/ckeditor/pictures/%{id}/%{file}.%{ext}")
  resources :p7_scaffolds
  devise_for :admin_users
  mount RailsAdmin::Engine => '/admin', as: 'rails_admin'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end

RailsAdmin.config do |config|

  ### Popular gems integration

  ## == Devise ==
  config.authenticate_with do
     warden.authenticate! scope: :admin_user
     #warden.authenticate! scope: :user
  end
  config.current_user_method(&:current_admin_user)

  ## == Cancan ==
  config.authorize_with :cancan

  ## == Pundit ==
  # config.authorize_with :pundit

  ## == PaperTrail ==
  # config.audit_with :paper_trail, 'User', 'PaperTrail::Version' # PaperTrail >= 3.0.0

  ### More at https://github.com/sferik/rails_admin/wiki/Base-configuration

  ## == Gravatar integration ==
  ## To disable Gravatar integration in Navigation Bar set to false
  # config.show_gravatar true

  config.actions do
    #dashboard                     # mandatory
    dashboard do
      statistics false
    end
    index                         # mandatory
    new
    export
    bulk_delete
    show
    edit
    delete
    show_in_app

    ## With an audit adapter, you can add:
    # history_index
    # history_show
    import
  end
  config.configure_with(:import) do |config|
    config.logging = true
  end
  config.model 'AdminUser' do
    import do
      include_all_fields
      exclude_fields :secret_token
    end
  end
=begin
  config.model 'P4Parent' do
    field :p4_title do
      visible do
        false
        if bindings[:controller].try(:current_administrator).try(:super_admin?)
          true
        else
          false
        end
      end
    end
  end
=end
  # config.navigation_static_links =[{ title: "yahoo", url: "http://www.yahoo.co.jp"}]
  config.navigation_static_links = []
  config.navigation_static_links.push ["p7_scaffold", "/p7_scaffolds"]
  config.navigation_static_links.push ["p9", "/p9_out/index"]
  #config.navigation_static_links.push "p7_scaffold" => "/p7_scaffolds"
  #config.navigation_static_links.push "p9" => "/p9_out/index"

  config.model 'P10Dinner' do
    list do
      field :title
      field :zensai_title
      field :fish_title
      field :meat_title
      field :main_title
      field :dessert_title
    end
    edit do
      field :title
      field :zensai_title
      field :zensai_detail, :ck_editor
      field :fish_title
      field :fish_detail, :ck_editor
      field :meat_title
      field :meat_detail, :ck_editor
      field :main_title
      field :main_detail, :ck_editor
      field :dessert_title
      field :dessert_detail, :ck_editor
    end
  end


end
=begin
class Encoding
  def self.name_list
    return [Encoding::CP932,Encoding::UTF_8] 
  end
end
=end
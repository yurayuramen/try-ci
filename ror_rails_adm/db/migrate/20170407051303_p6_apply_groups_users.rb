class P6ApplyGroupsUsers < ActiveRecord::Migration[5.0]
  def change
    create_table :p6_groups_users, id: false do |t|
      t.references :p6_group, index: true, null: false
      t.references :p6_user, index: true, null: false
    end
  end
end

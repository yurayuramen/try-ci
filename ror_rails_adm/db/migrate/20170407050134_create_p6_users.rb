class CreateP6Users < ActiveRecord::Migration[5.0]
  def change
    create_table :p6_users do |t|
      t.string :name
      t.string :email

      t.timestamps
    end
  end
end

class CreateP21Groups < ActiveRecord::Migration[5.0]
  def change
    create_table :p21_groups do |t|
      t.string :name
      t.integer :p21_user_id

      t.timestamps
    end
  end
end

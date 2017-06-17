namespace :dev01 do

  desc "Configure the variables that rails need in order to look up for the db
    configuration in a different folder"
  task :set_custom_db_config_paths do
    ENV['SCHEMA']                                     = 'db_dev01/schema.rb'
    Rails.application.config.paths['db']              = ['db_dev01']
    Rails.application.config.paths['db/migrate']      = ['db_dev01/migrate']
    Rails.application.config.paths['db/seeds.rb']     = ['db_dev01/seeds.rb']
    Rails.application.config.paths['config/database'] = ['config/database.yml']
    ActiveRecord::Migrator.migrations_paths           = 'db_dev01/migrate'
  end

  namespace :db do
    task drop: :set_custom_db_config_paths do
      Rake::Task["db:drop"].invoke
    end

    task create: :set_custom_db_config_paths do
      Rake::Task["db:create"].invoke
    end

    task migrate: :set_custom_db_config_paths do
      Rake::Task["db:migrate"].invoke
    end

    task rollback: :set_custom_db_config_paths do
      Rake::Task["db:rollback"].invoke
    end

    task reset: :set_custom_db_config_paths do
      Rake::Task['db:drop'].invoke
      Rake::Task['db:create'].invoke
      Rake::Task['db:migrate'].invoke
    end

    task seed: :set_custom_db_config_paths do
      Rake::Task["db:seed"].invoke
    end

    task version: :set_custom_db_config_paths do
      Rake::Task["db:version"].invoke
    end

    namespace :test do
      task prepare: :set_custom_db_config_paths do
        Rake::Task['db:drop'].invoke
        Rake::Task['db:create'].invoke
        Rake::Task['db:migrate'].invoke
      end
    end
  end

end